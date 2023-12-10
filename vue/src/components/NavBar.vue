
<template>
    <div class="navbar">
      <router-link to="/vote" v-if="token !== ''">
        <button>Go to Voting Page</button>
      </router-link>
      <router-link to="/profile" v-if="token !== ''">
        <button>Go to My Profile</button>
      </router-link>
      <router-link to="/social" v-if="token !== ''">
        <button>Message Board</button>
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
  
  
  <style>
  .vote {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
  }
  </style>