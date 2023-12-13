<template>
  <div id="background">
    <div class="character-detail">
      <div v-if="!editing">
        <p class="detail-details">
        <strong class="detail-name" >Name:</strong> {{ character.character_name }} |
        <strong class="detail-creature" >Creature:</strong> {{ character.creature }} |
        <strong class="detail-profession" >Profession :</strong> {{ character.class_profession }} |
        <strong class="detail-abilities" >abilities:</strong> {{ character.abilities }} |
        <strong class="detail-background" >background:</strong> {{ character.background }} |
        <strong class="detail-strength" >Strength:</strong> {{ character.character_strength }} |
        <strong class="detail-dexterity" >Dexterity:</strong> {{ character.character_dexterity }} |
        <strong class="detail-constitution" >Constitution:</strong> {{ character.character_constitution }} |
        <strong class="detail-intelligence" >Intelligence:</strong> {{ character.character_intelligence }} |
        <strong class="detail-wisdom" >Wisdom:</strong> {{ character.character_wisdom }} |
        <strong class="detail-charisma" >Charisma:</strong> {{ character.character_charisma }}
        <button class="edit-detail" v-on:click="startEditing">Edit</button>
        <button class="delete-detail" v-on:click="deleteMessage">Delete</button>
        </p>
      </div>

      <form v-if="editing" @submit="saveCharacter">
        <div>
            <label for="character_name">Character Name:</label>
            <input type="text" id="character_name" name="character_name" v-model="character_name" required/>
        </div>
        <div>
            <label for="background">Background:</label>
            <textarea v-model="background"></textarea>
        </div>
        <div>
            <label for="abilities">Abilities:</label>
            <textarea v-model="abilities"></textarea>
        </div>
        <div>  
        <label for="class_profession">Profession:</label>
        <select v-model="class_profession" id="profession" required>
            <option value="Barbarian">Barbarian</option>
            <option value="Bard">Bard</option>
            <option value="Cleric">Cleric</option>
            <option value="Druid">Druid</option>
            <option value="Fighter">Fighter</option>
            <option value="Monk">Monk</option>
            <option value="Paladin">Paladin</option>
            <option value="Ranger">Ranger</option>
            <option value="Rogue">Rogue</option>
            <option value="Sorcerer">Sorcerer</option>
            <option value="Warlock">Warlock</option>
            <option value="Wizard">Wizard</option>
        </select>
        </div>
        <button type="submit" class="save-character" v-on:click="editCharacter">Save</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  props: {
    character: Object,
  },
  data() {
    return {
      character_name: '',
      class_profession: '',
      abilities: '',
      background: '',
      editing: false,
    };
  },
  methods: {
    async editCharacter() {
  try {
    const characterData = {
        character_name: this.character_name,
        creature: this.character.creature,
        class_profession: this.class_profession || this.character.class_profession,
        character_strength: this.character.character_strength,
        character_dexterity: this.character.character_dexterity,
        character_constitution: this.character.character_constitution,
        character_intelligence: this.character.character_intelligence,
        character_wisdom: this.character.character_wisdom,
        character_charisma: this.character.character_charisma,
        abilities: this.abilities,
        background: this.background,
        };

        console.log('Character Data:', characterData);

        await axios.put(`http://localhost:9000/characters/${this.$route.params.id}`, characterData, {
          headers: {
            'Content-Type': 'application/json',
          },
        });

      } catch (error) {
        console.error('Error editing character:', error);
      }
    },

    startEditing() {
      this.editing = true;

      this.character_name = this.character.character_name;
      this.abilities = this.character.abilities;
      this.class_profession = this.character.class_profession;
      this.background = this.character.background;
    },

    async deleteMessage() {
      try {
        await axios.delete(`http://localhost:9000/characters/${this.$route.params.id}`);
        
        this.$router.push('/profile');

      } catch (error) {
        console.error('Error deleting character:', error);
      }
    }
  }
}
</script>
