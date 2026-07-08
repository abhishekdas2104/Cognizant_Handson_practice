# Security Note - OAuth2 Credentials

## Important: application.yml is NOT included in Git

For security reasons, `application.yml` containing OAuth2 credentials is excluded from Git.

## Setup Instructions

### Step 1: Create your application.yml
Copy the example file:
```bash
cp src/main/resources/application.yml.example src/main/resources/application.yml
```

Or manually create `src/main/resources/application.yml`

### Step 2: Add your Google OAuth2 credentials

Edit `application.yml` and replace:
- `YOUR_GOOGLE_CLIENT_ID_HERE` with your actual Google Client ID
- `YOUR_GOOGLE_CLIENT_SECRET_HERE` with your actual Google Client Secret

### Step 3: Get Google OAuth2 Credentials

Follow the instructions in `OAUTH2_SETUP_GUIDE.md` to get credentials from Google Cloud Console.

## Why is application.yml gitignored?

OAuth2 credentials are sensitive and should NEVER be committed to Git because:
- ❌ Anyone can see them in your repository
- ❌ They can be used to impersonate your application
- ❌ GitHub will block pushes containing secrets
- ❌ Security risk if repository is public

## What's Included in Git?

✅ `application.yml.example` - Template with placeholders
✅ All code files
✅ Documentation
❌ `application.yml` - Contains real credentials (gitignored)

## For Team Members

When you clone this repository:
1. Copy `application.yml.example` to `application.yml`
2. Add your own OAuth2 credentials
3. Never commit `application.yml` to Git

---

**Remember: Keep your credentials safe! 🔒**
