from __future__ import unicode_literals

from django.db import models
#from main.models import 

#LIFESTYLES = ['exercise', 'travel', 'read', 'film', 'social']

# Create your models here.

class DataLog(models.Model):
	userID = models.CharField(max_length = 2)
	timestamp = models.CharField(max_length = 20)
	lifestyle = models.CharField(max_length = 10)
	event = models.CharField(max_length = 10)
	duration = models.CharField(max_length = 20)
	start_time = models.CharField(max_length = 20)
	area_title = models.CharField(max_length = 30)

class UserData(models.Model):
	name = models.CharField(max_length = 50)
	age = models.CharField(max_length = 2)
	email = models.CharField(max_length = 50)
	sex = models.CharField(max_length = 10)
	fbid = models.CharField(max_length = 100)


