
<template>
  <div class="blank-box" />
  <div class="navbar">
    <router-link class="vote" to="/vote" v-if="token !== ''">
      <button>Go to Voting Page</button>
    </router-link>
    <router-link class="profile" to="/profile" v-if="token !== ''">
      <button>Go to My Profile</button>
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
  position: absolute;
  top: 23.8vh;
  padding: 1vh;
  width: 14.2vh;
}
.vote {
  position: absolute;
  top: 28.9vh;
  padding: 1vh;
  width: 14.8vh;
}
.blank-box {
  border: solid 2px;
  position: absolute;
  width: 12%;
  height: 60%;
  top: 24%;
}
</style>