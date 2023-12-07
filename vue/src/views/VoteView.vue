<template>
    <div>
      <h1>VotePage</h1>
  
      <!-- This is to navigate to the homepage -->
      <router-link to="/" v-if="$store.state.token !== ''">Home</router-link>
  
      <p>This is my vote page</p>
  
      <!-- navigate to the "logout" route -->
      <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>
    </div>
  </template>
  
  <script>
  export default {
  };
  </script>
  
  <style>
  </style>
  
  
 