from rest_framework import serializers
from api.models import DataLog, UserData


class DataLogSerializer(serializers.ModelSerializer):	
	class Meta:
		model = DataLog
		fields = ('userID', 'timestamp', 'lifestyle', 'event', 'duration', 'start_time', 'area_title')
	
class RegistrationSerializer(serializers.ModelSerializer):
	class Meta:
		model = UserData
		fields = ('name', 'age', 'email', 'sex', 'fbid')