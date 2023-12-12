<!-- Updated template -->
<template>
    <div class="character-detail">
      <div v-if="character && !editing">
        <p>
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
        <button @click="startEditing">Edit</button>
        </p>
      </div>
  
      <form v-if="editing" @submit.prevent="saveCharacter">
        <label for="character_name">Name:</label>
        <input v-model="character_name" type="text" id="character_name" required />
  
        <label for="creature">Creature:</label>
        <input v-model="creature" type="text" id="creature" required />
  
        <label for="class_profession">Profession:</label>
        <input v-model="class_profession" type="text" id="class_profession" required />
  
        <button type="submit">Save</button>
      </form>
    </div>
  </template>
  <script>
import axios from 'axios';

export default {
    props: {
  character: Object
 },
  data() {
    return {
      character_name: '',
      creature: '',
      class_profession: '',
      abilities: '',
      background: '',
      editing: false
    };
  },

  methods: {
    async editCharacter() {
      try {
        const characterData = {
          character_name: this.character_name,
          creature: this.creature,
          class_profession: this.class_profession,
          abilities: this.abilities,
          background: this.background,
        };

        console.log('Character Data:', characterData);

        await axios.put(`http://localhost:9000/characters/${this.characterId}`, characterData, {
          headers: {
            'Content-Type': 'application/json',
          },
        });
      } catch (error) {
        console.error('Error editing character:', error);
      }
    },
    async saveCharacter() {
      try {
        console.log('Saving character...');

        const characterData = {
        character_name: this.character_name,
        creature: this.creature,
        class_profession: this.class_profession,
        abilities: this.abilities,
        background: this.background,
        };

        console.log('Character Data:', characterData);

        const response = await axios.put(`http://localhost:9000/characters/${this.characterId}`, characterData, {
        headers: {
            'Content-Type': 'application/json',
        },
        });
            console.log('Character saved successfully:', response.data);

        this.character.character_name = this.character_name;
        this.character.creature = this.creature;
        this.character.class_profession = this.class_profession;
        this.character.abilities = this.abilities;
        this.character.background = this.background,

        this.editing = false;
    } catch (error) {
        console.error('Error saving character:', error);
    }
    }
  },
};
</script>