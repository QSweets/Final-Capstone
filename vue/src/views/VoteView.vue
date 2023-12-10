<template>
    <div class="vote">
      <h1>Ready, Set, Vote!</h1>
      
      <!-- This is to navigate to the homepage -->
      <router-link v-bind:to="{ name: 'home'}" v-if="$store.state.token !== ''">Home</router-link>
      <!-- navigate to the "logout" route -->
      <router-link v-bind:to="{ name: 'logout'}" v-if="$store.state.token !== ''">Logout</router-link>
      <GlobalLogoHeader />
      <!-- /*Want to display the MOTW details*/ -->
      <MOTW />
      
      <CharacterList />
      <Vote />

      
    </div>
  </template>
  
  <script>
  import Vote from '../components/Vote.vue';
  import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
  import MOTW from '../components/MOTW.vue';
  import CharacterList from '../components/CharacterList.vue'

  export default {
    components: {
      
      GlobalLogoHeader, 
      MOTW, 
      CharacterList, 
      Vote, 
  },

  data() {
    return {

    };
  },
};

  </script>
  

  <style>

  </style>
  
  
 