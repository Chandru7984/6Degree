package com.example.demo.serviceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.configuration.EmailUtil;
import com.example.demo.configuration.OtpUtil;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Designer;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
@CrossOrigin
public class UserServiceImpl implements UserService {

	@Autowired
	private OtpUtil otpUtil;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Designer saveUser(UserDto userDto) {

		String generateOtp = otpUtil.generateOtp();
		try {
			emailUtil.sendOtpemail(userDto.getEmail(), generateOtp);
		} catch (MessagingException e) {
			throw new RuntimeException("Unable to send otp please try again");
		}

		String seq = "secure"; // secret key used by password encoding
		int saltLength = 64; // salt length in bytes
		int iterations = 200000; // number of hash iteration
		int hashWidth = 256; // hash width in bits

		Designer designer = new Designer();

		if (Objects.nonNull(userDto.getName()) && !userDto.getName().isEmpty()) {
			designer.setName(userDto.getName());
		}
		if (Objects.nonNull(userDto.getEmail()) && !userDto.getEmail().isEmpty()) {
			designer.setEmail(userDto.getEmail());
		}
		if (Objects.nonNull(userDto.getMobile()) && !userDto.getMobile().isEmpty()) {
			designer.setMobile(userDto.getMobile());
		}
		if (Objects.nonNull(userDto.getAddressline1()) && !userDto.getAddressline1().isEmpty()) {
			designer.setAddressline1(userDto.getAddressline1());
		}
		if (Objects.nonNull(userDto.getAddressline2()) && !userDto.getAddressline2().isEmpty()) {
			designer.setAddressline2(userDto.getAddressline2());
		}
		if (Objects.nonNull(userDto.getLandmark()) && !userDto.getLandmark().isEmpty()) {
			designer.setLandmark(userDto.getLandmark());
		}
		if (Objects.nonNull(userDto.getCity()) && !userDto.getCity().isEmpty()) {
			designer.setCity(userDto.getCity());
		}
		if (Objects.nonNull(userDto.getState()) && !userDto.getState().isEmpty()) {
			designer.setState(userDto.getState());
		}
		if (Objects.nonNull(userDto.getCountry()) && !userDto.getCountry().isEmpty()) {
			designer.setCountry(userDto.getCountry());
		}
		if (Objects.nonNull(userDto.getPincode()) && !userDto.getPincode().isEmpty()) {
			designer.setPincode(userDto.getPincode());
		}
		if (Objects.nonNull(userDto.getPassword()) && !userDto.getPassword().isEmpty()) {
			designer.setPassword(userDto.getPassword());
		}

		designer.setOtp(generateOtp);
		designer.setOtpgeneratedtime(LocalDateTime.now());

		PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(seq, saltLength, iterations, hashWidth);
		String encode = passwordEncoder.encode(userDto.getPassword());
		designer.setPassword(encode);

		userRepository.saveAndFlush(designer);
		return designer;
	}

	@Override
	public ResponseEntity<Object> findByEmailAndPassword(LoginDto loginDto) {

		Designer designer = new Designer();

		Optional<Designer> designer1 = userRepository.findByEmail(loginDto.getEmail());

		String seq = "secure"; // secret key used by password encoding
		int saltLength = 64; // salt length in bytes
		int iterations = 200000; // number of hash iteration
		int hashWidth = 256; // hash width in bits

		MultiValueMap<String, String> status = new HttpHeaders();
		status.add("status", "200");

		if (designer1.isPresent()) {
			Designer designer2 = designer1.get();

			PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(seq, saltLength, iterations, hashWidth);
			boolean encode = passwordEncoder.matches(loginDto.getPassword().trim(), designer2.getPassword());

			if (encode) {
				return new ResponseEntity<>(designer2, status, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Incorrect password", status, HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<>("Incorrect password", status, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> verifyAccount(String email, String otp) {
		Designer findByEmail = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not found with this email: " + email));

		if (findByEmail.getOtp().equals(otp)
				&& Duration.between(findByEmail.getOtpgeneratedtime(), LocalDateTime.now()).getSeconds() < (8 * 60)) {
			findByEmail.setActive(1);
			userRepository.save(findByEmail);
			return new ResponseEntity<>("OTP verified you can login",  HttpStatus.ACCEPTED);
		}

		return  new ResponseEntity<>("Please regenerate OTP and try again",  HttpStatus.BAD_REQUEST	) ;

	}

	@Override
	public String regenerateOtp(String email) {
		Designer user = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not found with this email: " + email));

		String generateOtp = otpUtil.generateOtp();

		try {
			emailUtil.sendOtpemail(email, generateOtp);
		} catch (MessagingException e) {
			throw new RuntimeException("Unable to send otp please try again");
		}

		user.setOtp(generateOtp);
		user.setOtpgeneratedtime(LocalDateTime.now());

		userRepository.save(user);
		return "Email sent please verify account within 1 minute";
	}

	@Override
	public Optional<Designer> findDesignerById(Long designerid) {
		return this.userRepository.findById(designerid);
	}

}
