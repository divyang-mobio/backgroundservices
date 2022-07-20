import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  MethodChannel methodChannel = const MethodChannel("background");

  void startToastService() async {
    String value = await methodChannel.invokeMethod("toastService");
    print(value);
  }

  void startNotificationService() async {
    String value = await methodChannel.invokeMethod("notificationService");
    print(value);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [
          ElevatedButton(
              onPressed: () => startToastService(),
              child: const Text('call Toast message')),
          const SizedBox(height: 10),
          ElevatedButton(
              onPressed: () => startNotificationService(),
              child: const Text('call Notification Service'))
        ]),
      ),
    );
  }
}
