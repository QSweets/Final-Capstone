<template>
    <div>

    </div>
      <main>
      <!-- /*Want to display the MOTW details*/ -->
      <MOTW />
      <CharacterList />
      <Vote />
      <GlobalLogoHeader/>
    </main>
  </template>
  
  <script>
  import Vote from '../components/Vote.vue';
  import MOTW from '../components/MOTW.vue';
  import CharacterList from '../components/CharacterList.vue'
  import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';


  export default {
    components: {
    MOTW,
    CharacterList,
    Vote,
    GlobalLogoHeader,
},

  data() {
    return {

    };
  },
};

  </script>