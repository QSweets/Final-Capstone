<template>
<<<<<<< HEAD
  <div class="social">
    <h1>Let's Talk About It</h1>
    <!-- This is to navigate to the homepage -->
    <router-link to="/" v-if="$store.state.token !== ''">Home</router-link> &nbsp; | &nbsp;
    <!-- navigate to the "logout" route -->
    <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>
=======
  <div >
    <header class="flex">
      <h1>Topics</h1>
      <button class="btn-add" v-on:click="$router.push({ name: 'CommentAddTopicView' })">Add Topic</button>
    </header>
    <comment-topic-list v-bind:topics="topics"/>
>>>>>>> 79689c3edfb9caa3d3f8d5555eec03cf127e2b7e
  </div>
  <global-logo-header />
  <social v-bind:message="message" />
</template>

<script>
import MessageService from '../services/MessageService.js';
import Social from '../components/Social.vue';
import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';

export default {
components: {
    Social,
    GlobalLogoHeader
},
data() {
  return {
    topic: {},
    isLoading: true
  }
},
};
</script>

<style scoped>
</style>