<template>
  <div class="character-container">
    <div v-if="userCharacters.length > 0">
      <ul>
        <li v-for="character in userCharacters" :key="character.id" class="character-item">
          <div class="image-container">
            <img src="../Character imgs/1.png" />
            <div class="detailed-stats">
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
          </div> 
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
  },
};
</script>


<style scoped>
.character-container {
  display: inline-block;
}

.character-item {
  position: relative;
  margin-bottom: 20px;
}

.image-container {
  position: relative;
  display: inline-block;
}

.detailed-stats {
  position: absolute;
  top: 0;
  left: 100%;
  transform: translateX(10px); /* Adjust the distance from the image */
  opacity: 0;
  transition: opacity 0.3s ease;
  background: white;
  padding: 10px;
  border: 1px solid #ccc;
}

.image-container:hover .detailed-stats {
  opacity: 1;
}

.image-container img {
  width: 100px;
  height: auto;
}
</style>