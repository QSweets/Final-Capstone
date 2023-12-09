<template>
    <div class="vote">
      <h1>This is The Voting Page</h1>
  
      <!-- This is to navigate to the homepage -->
      <router-link v-bind:to="{ name: 'home'}" v-if="$store.state.token !== ''">Home</router-link>
      <!-- navigate to the "logout" route -->
      <router-link v-bind:to="{ name: 'logout'}" v-if="$store.state.token !== ''">Logout</router-link>
      <NavBar />
      <GlobalLogoHeader />
      <MOTW />
      <Vote />
      <CharacterList />

      
    </div>
  </template>
  
  <script>
  import NavBar from '../components/NavBar.vue';
  import Vote from '../components/Vote.vue';
  import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
  import MOTW from '../components/MOTW.vue';
  import CharacterList from '../components/CharacterList.vue'

  export default {
    components: {
      Vote, 
      GlobalLogoHeader, 
      MOTW, 
      NavBar, 
      CharacterList
  },

  data() {
    return {

    };
  },
};

  </script>
  

  <style>

  </style>
  
  
 