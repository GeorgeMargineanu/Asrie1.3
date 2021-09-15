import speech_recognition as sr
import socket

r = sr.Recognizer()

with sr.Microphone() as source:
    print('Say something')

    audio = r.listen(source)
    voice_data =  r.recognize_google(audio)

    print(type(voice_data))

    print(voice_data)

hote = '127.0.0.1'

client = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
client.connect(( hote, 9876))
client.send(voice_data.encode())
client.close

# salut
# salut 2
