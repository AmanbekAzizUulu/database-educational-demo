const prettier = require("prettier/parser-html");

module.exports = {
	parsers: {
		html: {
			...prettier.parsers.html,
			preprocess(text) {
				return text.replace(/<%.*?%>/gs, match => `<!-- ${match} -->`);
			}
		}
	}
};
