import java.text.*

System.out.println("my groovy script")

def cli = new CliBuilder(usage: 'slide')
cli.app(args: 1, argName: 'type', "type ('pdf', 'deck' or 'both')", required: true)
cli.env(args: 1, argName: 'file', 'file to convert', required: true)
def options = cli.parse(args)