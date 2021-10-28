import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class CustomElevatedButton extends StatefulWidget {
  final Widget title;
  final Function onPressed;
  final bool disable;

  const CustomElevatedButton({
    Key? key,
    required this.title,
    required this.onPressed,
    required this.disable,
  }) : super(key: key);

  @override
  _CustomElevatedButtonState createState() => _CustomElevatedButtonState();
}

class _CustomElevatedButtonState extends State<CustomElevatedButton> {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: SizedBox(
        width: displayWidth(context),
        height: displayHeight(context) * 0.055,
        child: ElevatedButton(
          style: ElevatedButton.styleFrom(
            primary: const Color(0xffF2A413),
            elevation: 0,
          ),
          onPressed: widget.disable ? null : () => widget.onPressed(),
          child: widget.title,
        ),
      ),
    );
  }
}
