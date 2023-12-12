<template>
  <div id="background">
    <h1 class="social-title">Let's Talk About It</h1>
  </div>
  <global-logo-header />
  <NavBar />
  <social v-bind:message="message" />
</template>

<script>
import MessageService from '../services/MessageService.js';
import Social from '../components/Social.vue';
import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
import NavBar from '../components/NavBar.vue';

export default {
components: {
    Social,
    GlobalLogoHeader,
    NavBar
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