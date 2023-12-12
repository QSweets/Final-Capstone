<template>
  <div class="character-container">
    <div v-if="userCharacters.length > 0">
      <ul>
        <li v-for="character in userCharacters" :key="character.id" class="character-item">
          <div class="image-container">
            <img :src="getRandomImage()" />
            <div class="detailed-stats">
              <button @click="editCharacter(character)">Edit</button>
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
      availableImages: [
        "../src/Character imgs/1.png",
        "../src/Character imgs/2.png",
        "../src/Character imgs/3.png",
        "../src/Character imgs/4.png",
      ],
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
    editCharacter(character) {
      console.log('Editing character:', character);
    },
    getRandomImage() {
      const randomIndex = Math.floor(Math.random() * this.availableImages.length);
      return this.availableImages[randomIndex];
    }
  }
};
</script>


<style scoped>
.character-container {
  display: flex;
  flex-wrap: wrap;
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
  transform: translateX(10px);
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