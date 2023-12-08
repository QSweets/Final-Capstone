<template>
  <div class="dropdown">
    <button class="dropbtn">Nav bar selection
    <div>
      <router-link v-bind:to="{ name: 'profile' }">My Profile</router-link>
    </div>
    <div>
      <router-link v-bind:to="{ name: 'profile' }">Home</router-link>
    </div>
    <div>
      <router-link v-bind:to="{ name: 'profile' }">Vote</router-link>
    </div>
    </button>
  </div>
</template>