<template>
    <div>
      <h1>Ready, Set, Vote!</h1>
    </div>
      <main>
      <!-- /*Want to display the MOTW details*/ -->
      <MOTW />
      <CharacterList />
      <Vote />
    </main>
  </template>
  
  <script>
  import Vote from '../components/Vote.vue';
  import MOTW from '../components/MOTW.vue';
  import CharacterList from '../components/CharacterList.vue'

  export default {
    components: {
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