<template>
  <h1 class="profile-title">Command your party</h1>
  <h2 class="select-party">My Party</h2>
  <button class="add-character" v-on:click="toggleForm">Add Character</button>
  <div class="character-creation-form">
  <div v-if="showForm" class="popup-form">
  <form v-on:submit.prevent="submitCharacter">
    <!-- <div>
      <label for="picture">Picture:</label>
      <input type="file" id="picture" name="picture" v-on:change="onFileChange" />
    </div> -->
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
      <label for="creature">Creature:</label>
      <select id="creature" v-model="creature" required>
         <option value="Dwarves">Dwarve</option>
         <option value="Elves">Elven</option>
         <option value="Halflings">Halfling</option>
         <option value="Humans">Human</option>
         <option value="Dragonborns">Dragonborn</option>
         <option value="Gnomes">Gnome</option>
         <option value="Half-elves">Half-elve</option>
         <option value="Half-orcs">Half-orc</option>
         <option value="Tieflings">Tiefling</option>
      </select>
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
    <div>
      <label for="character_strength">Strength:</label>
      <input type="text" id="strength" name="strength" v-model="character_strength" disabled />
    </div>
    <div>
      <label for="character_dexterity">Dexterity:</label>
      <input type="text" id="dexterity" name="dexterity"  v-model="character_dexterity" disabled />
    </div>
    <div>
      <label for="character_constitution">Constitution:</label>
      <input type="text" id="constitution" name="constitution"  v-model="character_constitution" disabled />
    </div>
    <div>
      <label for="character_intelligence">Intelligence:</label>
      <input type="text" id="intelligence" name="intelligence" v-model="character_intelligence" disabled/>
    </div>
    <div>
      <label for="character_wisdom">Wisdom:</label>
      <input type="text" id="wisdom" name="wisdom"  v-model="character_wisdom" disabled />
    </div>
    <div>
      <label for="character_charisma">Charisma:</label>
      <input type="text" id="charisma" name="charisma"  v-model="character_charisma" disabled />
    </div>
    <div>
    <button class="roll-stats" v-on:click="rollAllStats">Roll Stats</button>
    </div>
    <button type="submit" class="save-character" v-on:click="saveCharacter">Save Character</button>
  </form>
  </div>
  </div>
</template>
<script>
import axios from 'axios';
function generateRandomStat(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}
export default {
  data() {
    return {
      showForm: false,
      character_name: '',
      creature: '',
      class_profession: '',
      character_strength: generateRandomStat(8, 18),
      character_dexterity: generateRandomStat(8, 18),
      character_constitution: generateRandomStat(8, 18),
      character_intelligence: generateRandomStat(8, 18),
      character_wisdom: generateRandomStat(8, 18),
      character_charisma: generateRandomStat(8, 18),
      abilities: '',
      background: '',
      user_id: null,
    };
  },
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },
    isStatFieldDisabled(statField) {
      return false;
    },
    rollStat(statField) {
      this[statField] = generateRandomStat(8, 18);
    },
    getUserId() {
      return this.$store.state.user.id;
    },
    rollAllStats() {
      this.character_strength = generateRandomStat(8, 18);
      this.character_dexterity = generateRandomStat(8, 18);
      this.character_constitution = generateRandomStat(8, 18);
      this.character_intelligence = generateRandomStat(8, 18);
      this.character_wisdom = generateRandomStat(8, 18);
      this.character_charisma = generateRandomStat(8, 18);
    },
    async saveCharacter() {
      try {
        const characterData = {
          character_name: this.character_name,
          creature: this.creature,
          class_profession: this.class_profession,
          character_strength: this.character_strength,
          character_dexterity: this.character_dexterity,
          character_constitution: this.character_constitution,
          character_intelligence: this.character_intelligence,
          character_wisdom: this.character_wisdom,
          character_charisma: this.character_charisma,
          abilities: this.abilities,
          background: this.background,
          user_id: this.getUserId(),
        };
        console.log('Character Data:', characterData);
        await axios.post(`http://localhost:9000/characters`, characterData, {
          headers: {
            'Content-Type': 'application/json',
          },
        });
        console.log('Character Saved!');
        this.character_name = '';
        this.creature = '';
        this.class_profession = '';
        this.character_strength = '';
        this.character_dexterity = '';
        this.character_constitution = '';
        this.character_intelligence = '';
        this.character_wisdom = '';
        this.character_charisma = '';
        this.abilities = '';
        this.background = '';
        this.showForm = false;
      } catch (error) {
        console.error('Error saving character', error);
      }
    },
  },
};
</script>

<style>
.character-creation-form {
  display: flex;
  flex-direction: column;
  position: absolute;
  width: 8%;
  height: 65%;
  top: 18%;
  right: 5.7%;
  color: white;
}

</style>