
<template>
  <div class="blank-box" />
  <div class="navbar">
    <router-link class="vote" to="/vote" v-if="token !== ''">
      <button>Go to Voting Page</button>
    </router-link>
    <router-link class="profile" to="/profile" v-if="token !== ''">
      <button>Go to My Profile</button>
    </router-link>
  </div>
    
  </template>
  
  <script>
  export default {
  
    computed: {
      token() {
        return this.$store.state.token;
      },
    },
  };
  </script>
  