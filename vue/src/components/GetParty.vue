<template>
  <div class="character-container">
    <div v-if="userCharacters.length > 0">
      <ul>
        <li v-for="character in userCharacters" :key="character.id" class="character-item">
          <div class="character-info">
            <strong>Name:</strong> {{ character.character_name }} |
            <strong>Creature:</strong> {{ character.creature }} |
            <strong>Profession :</strong> {{ character.class_profession }} |
            <strong>abilities:</strong> {{ character.abilities }} |
            <strong>background:</strong> {{ character.background }} |
            <strong>Strength:</strong> {{ character.character_strength }} |
            <strong>Dexterity:</strong> {{ character.character_dexterity }} |
            <strong>Constitution:</strong> {{ character.character_constitution }} |
            <strong>Intelligence:</strong> {{ character.character_intelligence }} |
            <strong>Wisdom:</strong> {{ character.character_wisdom }} |
            <strong>Charisma:</strong> {{ character.character_charisma }}
          </div>
          <div class="character-image-container">
          </div>
        </li>
      </ul>
    </div>
    <div v-else>
      <p>No characters found.</p>
    </div>
    <div class="detailed-stats">
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
  },
};
</script>

<style scoped>
.character-container {
  display: inline-block;
  position: relative;
  margin-right: 20px;
}

.character-item {
  position: relative;
  margin-bottom: 20px;
}

.character-image-container {
  position: absolute;
  top: 0;
  left: 0;
  opacity: 0;
  transition: opacity 0.3s ease;
}

.character-item:hover .character-image-container {
  opacity: 1;
}

.character-image {
  width: 100px;
  height: auto;
}

.detailed-stats {
  position: absolute;
  top: 0;
  left: 100%; /* Adjust this based on your layout */
  background: white;
  padding: 10px;
  border: 1px solid #ccc;
}
</style>
