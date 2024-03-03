require 'mongo'
#TEST
def get_transactions_data
      transactions_block ||= []
      blank_transaction = Hash[from: '', to: '',
                               what: '', qty: '', test: '']
      loop do
        puts ''
        puts 'Enter your name for the new transaction'
        from = gets.chomp
        puts ''
        puts 'What do you want to send ?'
        what = gets.chomp
        puts ''
        puts 'How much quantity ?'
        qty  = gets.chomp
        puts ''
        puts 'Who do you want to send it to ?'
        to   = gets.chomp

        transaction = Hash[from: "#{from}", to: "#{to}", what: "#{what}", qty: "#{qty}"]
        transactions_block << transaction

        puts ''
        puts 'Do you want to make another transaction for this block ? (Y/n)'
        new_transaction = gets.chomp.downcase

        if new_transaction == 'y'
          self
        else
          begin
          uri = "mongodb+srv://joso:blockchain123@blockchain.k8fklvt.mongodb.net/?retryWrites=true&w=majority"

            options = { server_api: {version: "1"} }
            # Create a new client and connect to the serverx
            client = Mongo::Client.new(uri, options)
            admin_client = client.use('admin')
            blockchain_collection = client[:BlockChain]
            result =blockchain_collection.insert_one(transactions_blocka)
            # Check if the insertion was successful
          rescue Mongo::Error::OperationFailure => ex
            puts ex
          end
          return transactions_block
          break
        end
      end
    end
