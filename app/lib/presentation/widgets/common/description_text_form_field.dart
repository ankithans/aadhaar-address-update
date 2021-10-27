import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class DescriptionCustomTextFormField extends StatefulWidget {
  final String title;
  final String hintText;
  final TextEditingController textEditingController;

  const DescriptionCustomTextFormField({
    Key? key,
    required this.title,
    required this.hintText,
    required this.textEditingController,
  }) : super(key: key);

  @override
  State<DescriptionCustomTextFormField> createState() =>
      _DescriptionCustomTextFormFieldState();
}

class _DescriptionCustomTextFormFieldState
    extends State<DescriptionCustomTextFormField> {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(
        vertical: displayHeight(context) * 0.01,
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            widget.title,
            style: GoogleFonts.montserrat(
              fontSize: 12,
              fontWeight: FontWeight.w600,
              color: Colors.grey[500],
            ),
          ),
          SizedBox(
            height: displayHeight(context) * 0.011,
          ),
          TextFormField(
            maxLines: 10,
            style: GoogleFonts.montserrat(
              fontSize: 14,
            ),
            controller: widget.textEditingController,
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter some text';
              }
              return null;
            },
            decoration: InputDecoration(
              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(8),
                borderSide: BorderSide.none,
              ),
              hintStyle: GoogleFonts.montserrat(
                fontSize: 14,
                color: Colors.grey[400],
              ),
              errorStyle: GoogleFonts.montserrat(
                fontSize: 10,
              ),
              hintText: widget.hintText,
              filled: true,
              fillColor: Colors.grey[200],
              contentPadding: const EdgeInsets.only(
                left: 14.0,
                bottom: 10.0,
                top: 25.0,
              ),
              //   contentPadding: const EdgeInsets.symmetric(
              //     vertical: 40.0,
              //     horizontal: 14.0,
              //   ),
            ),
          ),
        ],
      ),
    );
  }
}
