<template>
    <div id="background">
      <div class="voting-form">
        <div v-for="party in parties" :key="party.partyId">
          <h3>{{ party.partyName }}</h3>
          <p>Party ID: {{ party.partyId }}</p>
          <p>Number of Characters: {{ party.characterIds.length }}</p>
          <ul>
            <li v-for="characterId in party.characterIds" :key="characterId">
              {{ getCharacterName(characterId) }}
            </li>
          </ul>
        </div>
      </div>
    <div class="voting-actions">
    <button id="custom-font" class="vote-btn" v-on:click="voteForSelectedUsers()">Vote</button>
    </div>
<NavBar />
    </div>
</template>
  
<script>
import NavBar from './NavBar.vue';
import axios from 'axios';
  
  export default {
    components: {
      NavBar,
    },
    data() {
      return {
        parties: [],
      };
    },
    mounted() {
      this.fetchParties();
    },
    methods: {
      async fetchParties() {
        try {
          const response = await axios.get('/api/parties');
          this.parties = response.data;
        } catch (error) {
          console.error('Error fetching parties:', error);
        }
      },
      voteForSelectedUsers() {
      },
      getCharacterName(characterId) {
      },
    },
  };
  </script>
  
  <style>
  </style>
  