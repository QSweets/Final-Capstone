<template>
  <div class="social">
    <h1>Let's Talk About It</h1>
    <!-- This is to navigate to the homepage -->
    <router-link to="/" v-if="$store.state.token !== ''">Home</router-link> &nbsp; | &nbsp;
    <!-- navigate to the "logout" route -->
    <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>
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