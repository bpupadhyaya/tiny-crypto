import socket


def main():
    cryptos = {'BTC': 'POW', 'ETH': 'POS', 'SOL': 'POH', 'ADA': 'POS', 'ALGO': 'ZK'}
    print('Starting server...')
    print('Creating the socket...')
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    print('Binding the socket to the port...')
    server_address = (socket.gethostname(), 8084)
    print('Staring up on', server_address)
    sock.bind(server_address)

    # Specify the number of connections allowed
    print('Listen for incoming connection...')
    sock.listen(1)
    while True:
        print('Waiting for a connection')
        connection, client_address = sock.accept()
        try:
            print('Connection from', client_address)
            while True:
                data = connection.recv(1024).decode()
                print('Received: ', data)
                if data:
                    key = str(data).upper()
                    response = cryptos[key]
                    print('Sending data back to the client: ', response)
                    connection.sendall(response.encode())
                else:
                    print('No more data from ', client_address)
                    break
        finally:
            connection.close()


if __name__ == '__main__':
    main()
