<template>
  <transition name="slide">
  <div v-if="isMobileNavOpen" class="side-panel-container">
    <h3 v-for="member in family" 
      :key="member.name"
      @click.prevent="toggleSidePanel">
      <router-link :to="member.route" class="link-text">
        {{ member.name }}
      </router-link>
      <hr/>
    </h3>
    <br/>
    <br/>
    <div @click.prevent="toggleSidePanel" 
         class="close-panel div-button">Close
         <md-icon>close</md-icon>
    </div>
  </div>
</transition>
</template>