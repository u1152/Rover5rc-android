import socket

HOST = ''                 # Symbolic name meaning all available interfaces
PORT = 7710           # Arbitrary non-privileged port
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((HOST, PORT))
s.listen(1)
conn, addr = s.accept()
print('Connected by', addr)
i = 0
while True:
    data = conn.recv(4)
    if not data: break
    print('{0}: {1} {2} {3} {4}'.format(i, data[0], data[1], data[2], data[3]))
    i += 1
conn.close()
