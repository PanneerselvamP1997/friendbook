from __future__ import unicode_literals

from django.db import models

# Create your models here.
class Quantified(models.Model):
	userID = models.CharField(max_length = 2)
	exercise = models.DecimalField(max_digits=5, decimal_places=4, default = 0.000)
	read = models.DecimalField(max_digits=5, decimal_places=4, default = 0.000)
	travel = models.DecimalField(max_digits=5, decimal_places=4, default = 0.000)
	film = models.DecimalField(max_digits=5, decimal_places=4, default = 0.000)
	social = models.DecimalField(max_digits=5, decimal_places=4, default = 0.000)

class Exercise(models.Model):
	userID = models.CharField(max_length = 2)
	timestamp = models.DateTimeField()
	event = models.CharField(max_length = 7)
	duration = models.DurationField(null = True)
	start_time = models.DateTimeField(null = True)
	area = models.CharField(max_length = 20, null = True)

#class Travel(models.Model):
	