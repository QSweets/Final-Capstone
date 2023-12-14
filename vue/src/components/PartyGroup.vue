<template>
    <div>
      <label for="partyName">Party Name:</label>
      <input v-model="partyName" type="text" id="partyName" />
  
      <div>
        <h3>Select Characters for the Party:</h3>
        <ul>
            <li v-for="character in userCharacters" :key="character.character_id">
                <input
                type="checkbox"
                :id="'characterCheckbox_' + character.character_id"
                :value="character.character_id"
                :checked="selectedCharacters[character.character_id]"
                @change="$toggleCharacterSelection(character)"
                />
                <label :for="'characterCheckbox_' + character.character_id">
                {{ character.character_name }} | {{ character.creature }} | {{ character.class_profession }} | Strength: {{ character.character_strength }} | 
                Dexterity: {{ character.character_dexterity }} | Constitution: {{ character.character_constitution }} | Intelligence: {{ character.character_intelligence }} |
                Wisdom: {{ character.character_wisdom }} | Charisma: {{ character.character_charisma }}
            </label>
          </li>
        </ul>
      </div>
  
      <div>
      
        <ul>
          <li v-for="characterId in selectedCharacters" :key="characterId">
            {{ getCharacterName(characterId) }}
          </li>
        </ul>
      </div>
  
      <button @click="createParty">Create Party</button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';

  export default {
    data() {
      return {
        partyName: '',
        selectedCharacters: {},
        userCharacters: [],
      };
    },
    mounted() {
      this.fetchCharacters();
    },
    methods: {
      toggleCharacterSelection(character) {
        const characterId = character.character_id;
        this.selectedCharacters[characterId] = !this.selectedCharacters[characterId];
      },
      createParty() {
        const selectedCharacterIds = Object.keys(this.selectedCharacters).filter(
                characterId => this.selectedCharacters[characterId]
            );

            if (selectedCharacterIds.length > 4) {
                console.error('Cannot select more than 4 characters.');
                return;
            }

            const party = {
                partyName: this.partyName,
                characterIds: selectedCharacterIds,
            };

            axios.post('/party/createParty', party)
            .then(response => {
                console.log('Party created successfully:', response.data);
                this.selectedCharacters = {};
            })
            .catch(error => {
                console.error('Error creating party:', error);
            });
        },
      async fetchCharacters() {
        try {
          const response = await axios.get(`http://localhost:9000/characters/all`);
          this.userCharacters = [...response.data];
          console.log('Characters:', this.userCharacters);
        } catch (error) {
          console.error('Error fetching characters:', error);
        }
      },
      getCharacterName(characterId) {
        const character = this.userCharacters.find(char => char.character_id === characterId);
        return character ? character.character_name : 'Unknown Character';
      },
    },
  };
</script>