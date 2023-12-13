<template>
    <div>

    </div>
      <main>
      <!-- /*Want to display the MOTW details*/ -->
      <MOTW />
      <CharacterList />
      <Vote />
      <GlobalLogoHeader/>
      <Navbar />
    </main>
  </template>
  
  <script>
  import Vote from '../components/Vote.vue';
  import MOTW from '../components/MOTW.vue';
  import CharacterList from '../components/CharacterList.vue'
  import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
  import Navbar from '../components/navbar.vue';

  export default {
    components: {
    MOTW,
    CharacterList,
    Vote,
    GlobalLogoHeader,
    Navbar
},

  data() {
    return {

    };
  },
};

  </script>