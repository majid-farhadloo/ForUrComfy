var mongoose = require('mongoose');

var Food = new mongoose.Schema({
  foodName: String,
  price: Number,
  quantity:Number
});

var orderSchema = new mongoose.Schema({
  food : [{type:Food}],
  name : String,
  cell: Number,
  location: String,
  completed: Boolean,
  time: Date
});


var order = mongoose.model ('order',orderSchema);
module.exports = order;
