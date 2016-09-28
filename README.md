###jrecapatcha-v2

`jrecaptcha-v2` is a Java library for verifying responses from the Google reCAPTCHA version 2 component.

<img src="data:image/png;base64,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">

It includes the following Maven modules:
- com.10xdev:jrecaptcha-v2-core: core library with dependency to com.googlecode.gson:gson.
- com.10xdev:jrecaptcha-v2-servlet: JSP/servlet library with an additional dependency to javax.servlet:servlet-api.
- com.10xdev:jrecaptcha-v2-sample: sample servlet.

#### Building
Run `mvn clean package` in the project root.

### Prerequisites
You will need a reCAPTCHA version 2 site key and secret key, which can be obtained from the [recpatcha console](https://www.google.com/recaptcha/admin#list)

#### Usage

On an HTML page (replacing your-site-key with your site key
```html
<head>
...
	<script src="https://www.google.com/recaptcha/api.js"></script>
</head>

<body>
...
	<form method="post" action="...">
	...
	<div class="g-recaptcha" data-sitekey="your-site-key"></div>
	...
	</form>
...
```

In your Java servlet:

```java
	private ServletRecaptchaVerifier recaptchaVerifier;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		recaptchaVerifier = new ServletRecaptchaVerifier(config.getInitParameter("site-key"),
				config.getInitParameter("secret-key"));
		super.init(config);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		...
		try {
			final VerificationResult verificationResult = recaptchaVerifier.verifyUserResponse(request);
			if (verificationResult.isSuccessful()) {
				// the check was successful
			} else {
				// the check was NOT successful
			}
		} catch (final AuthorizationException e) {
			// handle error, most likely network related
		}
		...
	}
```

HTTP proxy support
```java
	checker = new ServletRecaptchaVerifier(config.getInitParameter("site-key"),
				config.getInitParameter("secret-key")).withProxy(Type.HTTP, "proxy.bigco.com", 80);
```

#### Running the sample

Before running the sample, you will need to perform the following steps:
- Rename `web.sample.xml` to `web.xml`.
- Edit `web.xml`, replacing `your-site-key` and `your-secret-key` with the site and secret key obtained from the [recaptcha console](https://www.google.com/recaptcha/admin#list).
- Edit `index.html`, replacing `your-site-key` with your site key.