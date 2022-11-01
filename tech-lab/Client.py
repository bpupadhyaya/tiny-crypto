import socket


def main():
    print('Staring client...')
    print('Creating a TCP/IP socket...')
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    print('Connecting the socket to the server port...')
    server_address = (socket.gethostname(), 8084)
    print('Connecting to: ', server_address)
    sock.connect(server_address)
    print('Connected to server')
    try:
        print('Sending data...')
        message = 'BTC'
        print('Sending: ', message)
        sock.send(message.encode())
        data = sock.recv(1024).decode()
        print('Received from server: ', data)
    finally:
        print('Closing socket...')
        sock.close()


if __name__ == '__main__':
    main()

