var express = require('express');
var router = express.Router();
var User = require('../lib/User');
var md5= require('md5');
var mongoose = require('mongoose');


//CONNECT TO DATABASE
mongoose.connect("mongodb://heroku_vtkwsl62:1234qwer@ds235778.mlab.com:35778/heroku_vtkwsl61");
var db = mongoose.connection;
db.once("open",function() {
	console.log("DB connected!");
});
db.on("error", function (err) {
	console.log("DB ERROR :", err);
});


/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});


//POST REQUEST FOR SAVING USER TO DB
router.post('/register',function(req,res)
{
  if(!req.body.email) return res.json({"result":false, "message":"Email required"});
  if(!req.body.password) return res.json({"result":false, "message":"Password required"});
  if(!req.body.firstname) return res.json({"result":false, "message":"Firstname required"});
  if(!req.body.lastname) return res.json({"result":false, "message":"Lastname required"});
  if(!req.body.cell) return res.json({"result":false, "message":"Phone required"});

  var email = req.body.email;
  var password = md5(req.body.password);
  var firstname = req.body.firstname;
  var lastname = req.body.lastname;
  var cell = req.body.cell;

  var newUser = new User();
  newUser.email = email;
  newUser.password = password;
  newUser.firstname = firstname;
  newUser.lastname = lastname;
  newUser.cell = cell;

  User.findOne({email:email},function(err,user){
      if(err) {
          console.log(err);
          res.json(err);
      } else {
          if(user==null) {
                newUser.save(function(err,savedUser){
                if(err){
                   console.log(err);
                   return res.json({"result":false, "message":"Failed creating an account"});
                }
                return res.json({"result":true, "message":"Account Registered!"});
              });
          }else{
              console.log(user);
              res.json({"result":false, "message":"Email already exists"});
          }
      }
  });

});

//POST REQUEST FOR FINDING USER
router.post('/login',function(req,res,next)
{
  if(!req.body.email) return res.json({"result":false, "message":"Email required"});
  if(!req.body.password) return res.json({"result":false, "message":"Password required"});
  var email = req.body.email;
  var password = md5(req.body.password);

  User.findOne({email: email, password: password},function(err,user){
    if(err) {
        next(err);
      //return res.json({"result":false, "message":"Login Failed"});
    } else {
        //if user exists
        console.log(user);
        if(user) {
            return res.json({
                "result": true,
                "message": "Login success",
                "data": {
                    "firstname": user['firstname'],
                    "lastname": user['lastname'],
                    "cell": user['cell']
                }
          });
        }
        // if user doesn't exist
        res.json({
            "result": false,
            "message": "Login Failed"
        });
    }
  })
});

module.exports = router;
