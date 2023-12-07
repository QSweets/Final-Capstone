<template>
    <div>
      <h1>ProfilePage</h1>
  
      <!-- This is to navigate to the homepage -->
      <router-link to="/" v-if="$store.state.token !== ''">Home</router-link>
  
      
  
      <!-- navigate to the "logout" route -->
      <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>
      
      <Profile />
      <GlobalLogoHeader />
    </div>
  </template>
  
  <script>
  import Profile from '../components/Profile.vue'
  import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';

  export default {
    components: {
      Profile,
      GlobalLogoHeader
    }
  };
  </script>
  
  <style>
  </style>
  