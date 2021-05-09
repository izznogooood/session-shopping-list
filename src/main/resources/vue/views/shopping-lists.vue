<template id="shopping-lists">
  <v-row justify="center">
    <v-subheader>Cart collections</v-subheader>

    <v-expansion-panels popout>
      <v-expansion-panel
          v-for="(business, i) in this.$javalin.state.businesses"
          :key="i"
          hide-actions
      >
        <v-expansion-panel-header>
          <v-row
              align="center"
              class="spacer"
              no-gutters
          >
            <!-- Icon -->
            <v-col
                cols="2"
                xs="2"
                sm="1"
                md="1"
                xl="1"
            >
              <v-avatar
                  :color="business.accent"
                  size="36px"
              >
                <v-icon
                    :color="business.color"
                    v-text="business.icon"
                ></v-icon>
              </v-avatar>
            </v-col>

            <!-- Name -->
            <v-col
                cols="8"
                sm="4"
                md="3"
                lg="3"
                xl="3"
            >
              <strong v-html="business.name"></strong>

              <!-- "badge" items in list -->
              <span
                  v-if="business.shoppingList.length"
                  class="grey--text"
              >
                  &nbsp;({{ business.shoppingList.length }})
                </span>
            </v-col>

            <!-- TODO Create a preview function (IF business.shoppingList.lenth) -->
            <v-col
                v-if="preview"
                class="grey--text text-truncate hidden-xs-only"
            >
              {{ preview }}
            </v-col>
          </v-row>
        </v-expansion-panel-header>

        <v-expansion-panel-content class="text-center">

          <!--
          !!!! List Items Table !!!!
          Passing props in kebab-case (html is not case insensitive),
          Vue converts them to camelCase in Component
          -->
          <list-item-table v-if="business.shoppingList.length" :business-id="i" id="i"></list-item-table>
          <v-subheader v-else>No items in this collection...</v-subheader>

          <!-- Add list item -->
          <v-avatar
              @click="addItem(business.name)"
              :color="business.accent"
              size="36px"
              style="cursor: pointer;"
              class="mt-3"
          >
            <v-icon
                :color="business.color"
            >mdi-plus
            </v-icon>
          </v-avatar>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
    <span @click="addBusiness()" style="font-size: 48px; cursor: pointer; font-weight: 300;">
       +
    </span>
  </v-row>
</template>

<script>
  Vue.component("shopping-lists", {
    template: "#shopping-lists",
    vuetify: new Vuetify(),
    data: () => ({
      preview: "Tomatoes, onions, cheddar, chunky burger souce ..."
    }),
    methods: {
      addBusiness() {
        console.log('Adding business.....')
      },
      addItem(name) {
        console.log('Adding item.....')
      }
    },
    mounted() {
      // TODO: Remove
      console.log(this.$javalin.state.businesses)
    }
  });
</script>

<style>

</style>
