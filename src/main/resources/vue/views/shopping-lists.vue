<template id="shopping-lists">
  <h1>Hello {{ text }}</h1>
</template>

<script>
  Vue.component("shopping-lists", {
    template: "#shopping-lists",
    vuetify: new Vuetify(),
    data: () => ({
      text: "World"
    })

  });
</script>

<style>

</style>