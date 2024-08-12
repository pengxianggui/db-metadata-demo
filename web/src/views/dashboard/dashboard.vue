<template>
  <div class="page-container">
    <stock-log-chart></stock-log-chart>
    <stock-chart></stock-chart>
  </div>
</template>

<script>
import StockLogChart from "@/echart/stock-log-chart.vue";
import StockChart from "@/echart/stock-chart.vue";

export default {
  name: "dashboard",
  components: {StockChart, StockLogChart}
}
</script>


<style scoped lang="scss">

</style>
