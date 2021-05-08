<template id="shopping-lists">
  <section>
    <h1>SessionID: {{ $javalin.state.sessionId }}</h1>
    <h1>Stores:</h1>
    <h3 v-for="business in $javalin.state.businesses">
      {{ business.name }}
    </h3>
  </section>
</template>

<script>
  Vue.component("shopping-lists", {
    template: "#shopping-lists",
    vuetify: new Vuetify(),
    data: () => ({
      text: "World"
    }),
    mounted() {
      console.log(this.$javalin.state.businesses)
    }
  });
</script>

<style>

</style>