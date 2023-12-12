<template>
    <div>
      <div v-if="userCharacters.length > 0">
        <ul>
          <li v-for="character in userCharacters" v-bind:key="character.id">
            <strong>Name:</strong> {{ character.character_name }} |
            <strong>Creature:</strong> {{ character.creature }} |
            <strong>Profession :</strong> {{ character.class_profession }} |
            <strong>Image:</strong> 
            <strong>Image:</strong>
            <strong>abilities:</strong> {{ character.abilities }} |
            <strong>background:</strong> {{ character.background }} |
            <strong>Strength:</strong> {{ character.character_strength }} |
            <strong>Dexterity:</strong> {{ character.character_dexterity }} |
            <strong>Constitution:</strong> {{ character.character_constitution }} |
            <strong>Intelligence:</strong> {{ character.character_intelligence }} |
            <strong>Wisdom:</strong> {{ character.character_wisdom }} |
            <strong>Charisma:</strong> {{ character.character_charisma }}
        
          </li>
        </ul>
      </div>
      <div v-else>
        <p>No characters found.</p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';

  export default {
    data() {
      return {
        userCharacters: [],
      };
    },
    mounted() {
      this.fetchCharacters();
    },
    methods: {
      async fetchCharacters() {
        try {
            const userId = this.$store.state.user.id;
          const response = await axios.get(`http://localhost:9000/characters`);
          this.userCharacters = response.data;
        } catch (error) {
          console.error('Error fetching characters:', error);
        }
      },
    }
  }
</script>

  
  <style>
  
  </style>
  