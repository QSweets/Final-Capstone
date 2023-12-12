<template>
  <header id="logo">
  </header>
  <div class="logo-line"/>
  <img class="logo-eye2" src="src/ProfileImages/Logoeye.jpg" alt="cyclops ent eye" />
  <img class="logo-eye1" src="src/ProfileImages/Logoeye.jpg" alt="cyclops ent eye" />
  <img class="logo-img" src="src\ProfileImages\Logo.jpg" alt="cyclops ent" />

</template>

<style>
.logo-eye2 {
  width: 5%;
  position: absolute;
  top: .4%;
  right: .5%;
}
.logo-eye1 {
  width: 5%;
  position: absolute;
  top: .4%;
  left: .5%;
}
.logo-img {
  width: 14%;
  position: absolute;
  left: 44%;
  top: 1%;
}
#logo {
  display: flex;
  position: absolute;
  top: 0vh;
  left: .1vh;
  border: solid;
  width: 99.4%;
  height: 7.9%;
  justify-content: center;
  background-color: rgb(233, 184, 36);
}
.logo-line {
  border: solid 4px;
  width: 99.4%;
  position: absolute;
  top: 8.5vh;
  border-color: rgb(216, 63, 49);
}
</style>