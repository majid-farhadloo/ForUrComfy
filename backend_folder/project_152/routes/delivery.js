var express = require('express');
var router = express.Router();
var user = require('./users');
// var md5= require('md5');
// var mongoose = require('mongoose');


// //CONNECT TO DATABASE
// mongoose.connect("mongodb://heroku_vtkwsl62:1234qwer@ds235778.mlab.com:35778/heroku_vtkwsl61");
// var db = mongoose.connection;
// db.once("open",function() {
//     console.log("DB connected!");
// });
// db.on("error", function (err) {
//     console.log("DB ERROR :", err);
// });

/* GET users listing. */
router.post('/checkout', function(req, res) {
    // res.send('respond with a resource');
    // var user  = req.session.user;
    var user_fname = req.session.firstname;
    if(!user_fname)
    {
        return res.json({"result":false,"message":"user not saved in session"});
    }
    else
    {
        return res.json({"result":true, "message":"user saved", "data": user_fname
     })
    }
});

module.exports = router;
