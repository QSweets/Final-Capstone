
<template>
  <div class="blank-box" />
  <div class="navbar">
    <router-link class="home" to="/" v-if="token !== ''">
      <button>Home</button>
    </router-link>
    <router-link class="vote" to="/vote" v-if="token !== ''">
      <button>Voting</button>
    </router-link>
    <router-link class="profile" to="/profile" v-if="token !== ''">
      <button>My Profile</button>
    </router-link>
    <router-link class="social" to="/social" v-if="token !== ''">
      <button>Message Board</button>
    </router-link>
    <router-link class="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
      <button>Logout</button>
    </router-link>
  </div>
  <div 
  class="side-panel-button div-button"
  @click.prevent="toggleSidePanel">
    Menu
</div>

  </template>
  
  <script>


  export default {
    methods: {
    toggleSidePanel() {
      this.$store.dispatch("toggleNav")
    }
  },
    computed: {
      token() {
        return this.$store.state.token;
      },
    },
  };
  </script>
  
<style>
.home {
  position: absolute;
  top: 23.8%;
  padding: 1%;
  width: 14.8%;
}
.profile { 
  position: absolute;
  top: 28.9%;
  padding: 1%;
  width: 14.8%;
}
.vote {
  position: absolute;
  top: 34%;
  padding: 1%;
  width: 14.8%;
}
.social {
  position: absolute;
  top: 39%;
  padding: 1%;
  width: 14.8%;
}


.logout {
  position: absolute;
  top: 44%;
  padding: 1%;
  width: 14.8%;
}
.blank-box {
  border: solid 2px;
  position: absolute;
  width: 10%;
  height: 30%;
  top: 24%;
}
</style>