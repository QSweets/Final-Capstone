<template>
  <div class="character-container">
    <div v-if="userCharacters.length > 0">
      <ul>
        <li v-for="character in userCharacters" :key="character.id" class="character-item">
          <div class="image-container">
            <router-link :to="{ name: 'characterDetails', params: { id: character.id } }">
              <div class="random-img">
              <img :src="getRandomImage()" />
              </div>
            </router-link>
            <div id="custom-font" class="detailed-stats">
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
      <p id="custom-font" class="no-character">No characters found.</p>
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
    goToCharacterDetail(characterId) {
      this.$router.push({ name: 'characterDetails', params: { id: characterId } });
    },
    getRandomImage() {
      const randomIndex = Math.floor(Math.random() * this.availableImages.length);
      return this.availableImages[randomIndex];
    }
  }
};
</script>


<style scoped>


.character-item {
  position: absolute;
  margin-bottom: 20px;
  list-style: none; 
  cursor: pointer;
}

.image-container {
  display: inline-block;
}

.detailed-stats {
  position: absolute;
  transform: translateX(10px);
  opacity: 1;
  transition: opacity 0.3s ease;
  background: white;
  padding: 10px;
  z-index: 1;
}

.character-item:hover .detailed-stats {
  opacity: 1;
}

.image-container img {
  width: 15vh;
}
</style>

