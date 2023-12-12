<template>
    <div class="character-detail">
      <strong>Name:</strong> {{ character.character_name }} |
      <strong>Creature:</strong> {{ character.creature }} |
      <strong>Profession :</strong> {{ character.class_profession }} |
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        character: null,
      };
    },
  
    mounted() {
      this.fetchCharacterDetails();
    },
  
    methods: {
      async fetchCharacterDetails() {
        try {
          const response = await axios.get('http://localhost:9000/characters/${this.characterId}');
          this.character = response.data;
        } catch (error) {
          console.error('Error fetching character details:', error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
 
  </style>
  