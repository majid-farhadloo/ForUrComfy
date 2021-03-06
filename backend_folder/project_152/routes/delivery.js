var express = require('express');
var router = express.Router();
var order = require('../lib/order')
// var md5= require('md5');
var mongoose = require('mongoose');
var moment = require('moment');

mongoose.connect("mongodb://heroku_vtkwsl62:1234qwer@ds235778.mlab.com:35778/heroku_vtkwsl61");
var db = mongoose.connection;
db.once("open",function() {
    console.log("DB connected!");
});
db.on("error", function (err) {
    console.log("DB ERROR :", err);
});

// var query = order.find({});
// console.log(query['foodName']);

router.get('/request', function(req, res) {
    // var returnorder = order.find({completed:false}, function(err, result) {
    // if (err) throw err;
    order.findOne({completed:false}).sort({_id: 1}).exec(function(err,result)
  {
    if(err) throw err;
    res.status(200).json(result);
    });
  });

router.post('/claim',function(req,res){
  var orderid= req.body._id;
  order.update({_id: orderid }, { $set: {completed:true}}).exec(function(err,result)
  {
      return res.status(200).json(result);
    });
  });
  //Tank.update({ _id: id }, { $set: { size: 'large' }}, callback);
  //this is to update completed to

router.get('/done',function(req,res){
  order.findOne().update({completed:true})
})

  router.get('/all', function(req, res) {
      // var returnorder = order.find({completed:false}, function(err, result) {
      // if (err) throw err;
      order.find({completed:false}).sort('time').exec(function(err,result)
    {
      if(err) throw err;
      res.status(200).json(result);
      });


    });

module.exports = router;
