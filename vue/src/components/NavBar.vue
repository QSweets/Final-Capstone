
<template>
  <div class="blank-box" />
  <div class="navbar">
    <router-link class="vote" to="/vote" v-if="token !== ''">
      <button>Voting</button>
    </router-link>
    <router-link class="profile" to="/profile" v-if="token !== ''">
      <button>My Profile</button>
    </router-link>
    <router-link class="social" to="/social" v-if="token !== ''">
      <button>Message Board</button>
    </router-link>
  </div>

  </template>
  
  <script>
  export default {
  
    computed: {
      token() {
        return this.$store.state.token;
      },
    },
  };
  </script>
  
<style>
  .profile { 
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  position: absolute;
  top: 23.8vh;
  padding: 1vh;
  width: 14.8vh;
}
.vote {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  position: absolute;
  flex-wrap: nowrap;
  top: 28.9vh;
  padding: 1vh;
  width: 14.8vh;
}
.social {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  position: absolute;
  flex-wrap: nowrap;
  top:34vh;
  padding: 1vh;
  width: 14.8vh;
}
.blank-box {
  border: solid 2px;
  position: absolute;
  width: 8%;
  height: 60%;
  top: 24%;
}
</style>