<template>
    <h1>Character Details</h1>
    <CharacterDetail v-bind:character="character"/>
</template>


<script>
import axios from 'axios';
import CharacterDetail from '../components/CharacterDetail.vue';



export default {
data(){
    return {
        character: {}
    }
},
components: {
    CharacterDetail
},
methods: {
    async fetchCharacterDetails() {
      try {
        const response = await axios.get(`http://localhost:9000/characters/${this.$route.params.id}`);
        this.character = response.data;
      } catch (error) {
        console.error('Error fetching character details:', error);
      }
    },
    async startEditing() {
      this.editing = true;

      this.character_name = this.character.character_name;
      this.creature = this.character.creature;
      this.class_profession = this.character.class_profession;
    },
  },
  created() {
    this.fetchCharacterDetails();
  }  
}
</script>