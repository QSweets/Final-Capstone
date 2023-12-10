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
            <img :src="'data:image/jpeg;base64,' + arrayBufferToBase64(character.image)" alt="Character Image">|
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
          const response = await axios.get(`http://localhost:9000/characters/${userId}`);
          this.userCharacters = response.data;
        } catch (error) {
          console.error('Error fetching characters:', error);
        }
      },
      arrayBufferToBase64(buffer) {
      let binary = '';
      let bytes = new Uint8Array(buffer);
      let len = bytes.byteLength;

      for (let i = 0; i < len; i++) {
        binary += String.fromCharCode(bytes[i]);
      }

      const base64String = btoa(binary);
      console.log('Base64 Image:', base64String.substring(0, 50)); // Log the first 50 characters

      return base64String;
    },
  }
}
</script>

  
  <style>
  
  </style>
  